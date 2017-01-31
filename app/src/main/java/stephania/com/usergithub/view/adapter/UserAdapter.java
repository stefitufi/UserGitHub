package stephania.com.usergithub.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import stephania.com.usergithub.R;
import stephania.com.usergithub.model.Items;
import stephania.com.usergithub.utils.StringUtil;

/**
 * Adapter que infla la vista con cada usuario
 *
 * @author <a href="stefiluna@gmail.com">Stephania Moreno</a>
 */
public class UserAdapter extends BaseAdapter{

    /**
     * List de tipo {@link Items}
     */
    private List<Items> users ;

    /**
     * Variable de tipo {@link Context}
     */
    private Context context ;

    /** Tag para logs **/
    private static final String TAG_LOG = UserAdapter.class.getName();

    /**
     * Contructor del adapter
     *
     * @param ctx
     *          Contexto
     * @param items
     *          Items de la lista
     */
    public UserAdapter (Context ctx, List<Items> items) {
        super();
        this.context = ctx ;
        this.users = items ;
    }

    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * Metodo el cual infla la lsita con la informacion que viene del web service
     * @param i
     *          Posicion de los item de la lista
     * @param view
     *          Vista
     * @param viewGroup
     * @return Retorna nombre de usuario e informacion
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mLayoutInflater = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        View mView = mLayoutInflater.inflate(R.layout.item_user, viewGroup, false);
        ImageView mAvatarIv = (ImageView)mView.findViewById(R.id.avatar_iv);
        TextView mLoginTv = (TextView)mView.findViewById(R.id.login_tv);

        Items user = users.get(i);

        Picasso.with(context).load(user.getAvatar_url()).resize(100,100).into(mAvatarIv);
        mLoginTv.setText(StringUtil.capitalize(user.getLogin()));
        Log.d(TAG_LOG, user.getLogin());

        return mView;
    }
}
