package stephania.com.usergithub.model;

import java.io.Serializable;

/**
 * Representacion de la clase {@link Items}
 *
 * @author <a href="stefiluna@gmail.com">Stephania Moreno</a>
 */
public class Items implements Serializable {

    /** String que contiente el login **/
    private String login;

    /** Enteto que contiene el id del usuario **/
    private int id;

    /** String que contiene la url de la imagen **/
    private String avatar_url;

    /** String vacio **/
    private String gravatarId;

    /** String que contiene la url info de cada usuario **/
    private String url;

    /** String que contiene la url info **/
    private String htmlUrl;

    /** String que contiene la cantiad de seguidores **/
    private String followersUrl;

    /** String que contiene la cantidad de perosnas que sigue  **/
    private String followingUrl;

    /** String que contiene la cantidad de publicaciones **/
    private String gistsUrl;

    /** String que contiene la url de la imagen **/
    private String starredUrl;

    /** String que contiene la url de suscripciones **/
    private String subscriptionsUrl;

    /** String que contiene la url de organizaciones **/
    private String organizationsUrl;

    /** String que contiene la cantidad de respositorios **/
    private String reposUrl;

    /** String que contiene url de eventos **/
    private String eventsUrl;

    /** String que contiene eventos recibidos **/
    private String receivedEventsUrl;

    /** String que contiene el tiipo de usuario **/
    private String type;

    /** Boolean que contiene si es administrador**/
    private boolean siteAdmin;

    /** Float que contiene la cntidad de puntaje **/
    private float score;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

}
