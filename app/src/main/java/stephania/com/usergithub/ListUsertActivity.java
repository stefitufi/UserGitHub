package stephania.com.usergithub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import stephania.com.usergithub.model.Items;
import stephania.com.usergithub.model.User;
import stephania.com.usergithub.rest.RestClient;
import stephania.com.usergithub.utils.ConstantUtil;
import stephania.com.usergithub.view.adapter.UserAdapter;

/**
 * Actividad Lista de usuarios
 *
 * @author <a href="stefiluna@gmail.com">Stephania Moreno</a>
 */
@ContentView(R.layout.activity_list_usert)
public class ListUsertActivity extends RoboActionBarActivity {

    /**
     * Swipe Refresh
     */
    @InjectView(R.id.container_srl)
    private SwipeRefreshLayout mContainerSwipeRefreshLayout;

    /**
     * ListView que muestra la lista de usuarios
     */
    @InjectView(R.id.user_lv)
    private ListView mUserLv;

    /**
     * Variable de tipo {@link UserAdapter}
     */
    private UserAdapter adapter ;

    /**
     * List de tipo {@link Items}
     */
    private List<Items> mItems;

    /**
     * Variable de tipo {@link Items}
     */
    private Items mItem;

    /** Llave para enviar informacion del item seleccioando **/
    public static final String ITEMS = "ITEM";

    /** Tag para logs **/
    private static final String TAG_LOG = ListUsertActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItems = new ArrayList<Items>();

        //Crea objeto de tipo Items
        mItem = new Items();

        //Invocacion del metodo
        cargarDatos();

        // Evento para actualizar la lista
        mContainerSwipeRefreshLayout.setOnRefreshListener(new
          SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Invocacion del metodo
                cargarDatos();
            }
        });

        // Configure the refreshing colors
        mContainerSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        //Onclick listener de la lista
        mUserLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListUsertActivity.this, DetailUserActivity.class);
                mItem = mItems.get(i);
                intent.putExtra(ITEMS, mItem);
                startActivity(intent);
            }
        });
    }

    /**
     * Metodo que carga la infromacion del web service
     */
    private void cargarDatos(){
        final ProgressDialog dialog = ProgressDialog.show(this, "", getString(R.string.loading));
        RestClient.ApiInterface mCliente = RestClient.getClient();
        Call<User> call = mCliente.getUsersNamedTom(ConstantUtil.NAME_USER);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                dialog.dismiss();
                Log.d(TAG_LOG, "Status Code = " + response.code());
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    User result = response.body();
                    Log.d(TAG_LOG, "response = " + new Gson().toJson(result));

                    mItems = result.getItems();

                    Log.d(TAG_LOG, "Items = " + mItems.size());
                    adapter = new UserAdapter(ListUsertActivity.this, mItems);
                    mUserLv.setAdapter(adapter);
                    mContainerSwipeRefreshLayout.setRefreshing(false);
                } else {
                    Toast.makeText(ListUsertActivity.this, R.string.conexion, Toast.LENGTH_LONG);
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }
            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
            }
        });
    }

    /** Metodo que devuelve a la actividad {@link ListUsertActivity} **/
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
