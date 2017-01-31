package stephania.com.usergithub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import stephania.com.usergithub.model.Items;
import stephania.com.usergithub.model.Url;
import stephania.com.usergithub.rest.RestClientUrl;

/**
 * Actividad que muestra Detalle del usuarios
 *
 * @author <a href="stefiluna@gmail.com">Stephania Moreno</a>
 */
@ContentView(R.layout.activity_detail_user)
public class DetailUserActivity extends RoboActionBarActivity {

    /**
     * Swipe Refresh
     */
    @InjectView(R.id.detail_user_srl)
    private SwipeRefreshLayout mDetailUserSwipeRefreshLayout;

    /**
     * TextView que contiene nombre de usuario
     */
    @InjectView(R.id.name_user_tv)
    private TextView mUserNameTv;

    /**
     * TextView que contien el e-mail
     */
    @InjectView(R.id.email_tv)
    private TextView mEmailTv;

    /**
     * TextView que contiene cantidad
     * de respositoriso publicados
     */
    @InjectView(R.id.public_repos_tv)
    private TextView mPublicReposTv;

    /**
     * TextView que contiene cantidad
     * de repositorios subidos
     */
    @InjectView(R.id.public_gists_tv)
    private TextView mPublicGitsTv;

    /**
     * Textview que contiene cantidad
     * de seguidores
     */
    @InjectView(R.id.followers_tv)
    private TextView mFollowerTv;

    /**
     * TextView que cotiene cantidas
     * de personas a seguir
     */
    @InjectView(R.id.following_tv)
    private TextView mFollowingTv;

    /**
     * TextView que contiene la
     * fecha de creacion
     */
    @InjectView(R.id.created_tv)
    private TextView mCreatedTv;

    /**
     * TextView que cotiene fecha de
     * actualizacion del repositorio
     */
    @InjectView(R.id.updated_tv)
    private TextView mUpdateTv;

    /**
     * ImageView que muestra la
     * imagen del usuario
     */
    @InjectView(R.id.user_iv)
    private ImageView mUserIv;

    /**
     * Variable de tipo {@link Items}
     */
    public static Items mItems;

    /** Llave que carga la informacion del item seleccioando **/
    public static final String ITEMS = "ITEM";

    /** Tag para logs **/
    private static final String TAG_LOG = DetailUserActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItems = (Items) getIntent().getSerializableExtra(ITEMS);

        // Inicializa el metdo AsynTask
        new HttpRequestTask().execute();

        // Evento para actualizar la información
        mDetailUserSwipeRefreshLayout.setOnRefreshListener(new
           SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new HttpRequestTask().execute();
            }
        });

        // Configure the refreshing colors
        mDetailUserSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    /**
     * Metodo que carga la infromacion desde el servicio web
     */
    private class HttpRequestTask extends AsyncTask<Void, Void, Url> {
        ProgressDialog dialog;
        private HttpRequestTask() {}

        @Override
        protected void onPreExecute(){
            dialog = ProgressDialog.show(DetailUserActivity.this, "",
                    getString(R.string.loading));
        }
        @Override
        protected Url doInBackground(Void... params) {
            try {
                Url infoUser = RestClientUrl.getInfo(mItems.getUrl());
                Log.d(TAG_LOG, "response = " + new Gson().toJson(infoUser));
                return infoUser;
            } catch (Exception e) {
                Log.e(TAG_LOG, e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Url infoUser) {
            cargarInfo(infoUser);
            dialog.dismiss();
            mDetailUserSwipeRefreshLayout.setRefreshing(false);
        }
    }

    /**
     * Este método carga la informacion del usuario seleccionado
     *
     * @param mInfoUser Variable de tipo Url
     */
    private void cargarInfo(Url mInfoUser){
        mUserNameTv.setText(mInfoUser.getName());
        Picasso.with(this).load(mInfoUser.getAvatar_url()).resize(100,100).into(mUserIv);
        mEmailTv.setText(mInfoUser.getEmail());
        mPublicReposTv.setText(String.valueOf(mInfoUser.getPublic_repos()));
        mPublicGitsTv.setText(String.valueOf(mInfoUser.getPublic_gists()));
        mFollowerTv.setText(String.valueOf(mInfoUser.getFollowers()));
        mFollowingTv.setText(String.valueOf(mInfoUser.getFollowing()));
        mCreatedTv.setText(mInfoUser.getCreated_at());
        mUpdateTv.setText(mInfoUser.getUpdated_at());
    }

    /**
     * Metodo que devuelve a la actividad {@link ListUsertActivity}
     **/
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, ListUsertActivity.class);
        startActivity(i);
    }
}
