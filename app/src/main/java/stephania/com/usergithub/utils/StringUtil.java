package stephania.com.usergithub.utils;


import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Converter;

/**
 * Actividad Lista de usuarios
 *
 * @author <a href="stefiluna@gmail.com">Stephania Moreno</a>
 */
public class StringUtil implements Converter<String> {

    /**
     * Meotodo manejo de web service
     * @param body
     * @return
     * @throws IOException
     */
    @Override
    public String fromBody(ResponseBody body) throws IOException {
        return body.toString();
    }

    /**
     * Meotodo manejo de web service
     * @param value
     * @return
     */
    @Override
    public RequestBody toBody(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

    /**
     * Metodo que convierte el primer caracter en mayuscula
     * @param word
     *          Palabra a acfectar
     * @return
     *          Palabra con primera letra en mayuscula
     */
    public static String capitalize(String word){
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
