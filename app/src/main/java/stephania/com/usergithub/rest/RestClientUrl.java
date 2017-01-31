package stephania.com.usergithub.rest;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import stephania.com.usergithub.model.Url;

/**
 * Clase que realiza peticion al servidor de la informacion del usuario
 *
 * @author <a href="stefiluna@gmail.com">Stephania Moreno</a>
 */
public class RestClientUrl {

    /**
     * Meotodo que reliza peticion al web service
     * @param mUrl
     *          Url a la cual se realiza la consulta
     * @return
     *      Informacion del usuario
     */
    public static Url getInfo(String mUrl){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Url infoUser = restTemplate.getForObject(mUrl, Url.class);

        return infoUser;
    }

}
