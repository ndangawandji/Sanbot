/**
 * Model class representing an hotel
 * Developed  by Ndanga Wandji.
 */

package fr.mylocalphone.sanbot.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.commons.DrawablePicture;


public class Hotel {

    /**
     * Attributes containing the display properties of an hotel
     */
    private static int id = -1;
    private static String name;
    private static Drawable logo;
    static AddressInfos aInfos;
    static ExtraInfos eInfos;
    private static List<ServiceInfo> serviceInfos = new ArrayList<>();


    public static int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static Drawable getLogo() {
        return logo;
    }

    public static AddressInfos getaInfos() {
        return aInfos;
    }

    public static ExtraInfos geteInfos() {
        return eInfos;
    }

    public static List<ServiceInfo> getServiceInfos() {
        return serviceInfos;
    }

    /**
     * Default constructor
     * Use this constructor when your are likely to get an already-built hotel somewhere in the app
     */
    public Hotel() {

    }

    /**
     * Don't use this constructor to construct an hotel. Use createHotel method instead of.
     * @param id
     * @param name
     * @param logo
     */
    private Hotel(int id, String name, Drawable logo) {
        Hotel.id = id;
        Hotel.name = name;
        Hotel.logo = logo;
        //Hotel.background = background;
        createServiceInfos(id);
        createExtraInfos(id);
    }

    /**
     * Use this method when you are likely to construct an hotel for the first time in the app.
     * @param Id
     * @param res
     * @return
     */
    public static Hotel createHotel(int Id, Resources res) {
        int id = -1;
        String name = null;
        Drawable logo = new DrawablePicture();
        switch(Id){
            case Constants.HOTEL_ID_ACACIAS_ETOILE :
                id = Constants.HOTEL_ID_ACACIAS_ETOILE;
                name = res.getString(R.string.acacias_etoile_hotel_name);
                logo = res.getDrawable(R.drawable.logo_header_acacias_etoile);
                break;
            case Constants.HOTEL_ID_LA_VILLA_DES_TERNES :
                id = Constants.HOTEL_ID_LA_VILLA_DES_TERNES;
                name = res.getString(R.string.la_villa_des_ternes_hotel_name);
                logo = res.getDrawable(R.drawable.logo_header_la_villa_des_ternes);
                break;
            case Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA :
                id = Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA;
                name = res.getString(R.string.les_jardins_de_la_villa_hotel_name);
                logo = res.getDrawable(R.drawable.logo_header_les_jardins_de_la_villa);
                break;
            case Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES :
                id = Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES;
                name = res.getString(R.string.magda_champs_elysees_hotel_name);
                logo = res.getDrawable(R.drawable.logo_header_magda_champs_elysees);
                break;
            default :
                break;
        }
        return new Hotel(id, name, logo);
    }

    /**
     * This method is for providing service informations about an hotel. Never use this in the app.
     * @param hotelId
     */
    private static void createServiceInfos(int hotelId) {
        switch (hotelId) {
            case Constants.HOTEL_ID_ACACIAS_ETOILE :
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_BREAKFAST, Constants.SERVICE_NAME_BREAKFAST));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_HONESTY_BAR, Constants.SERVICE_NAME_HONESTY_BAR));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_WIFI, Constants.SERVICE_NAME_WIFI));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_MEETING_ROOM, Constants.SERVICE_NAME_MEETING_ROOM));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_EXTRA_AMENITIES, Constants.SERVICE_NAME_EXTRA_AMENITIES));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_CONCIERGE, Constants.SERVICE_NAME_CONCIERGE));
                break;
            case Constants.HOTEL_ID_LA_VILLA_DES_TERNES :
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_BREAKFAST, Constants.SERVICE_NAME_BREAKFAST));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_HONESTY_BAR, Constants.SERVICE_NAME_HONESTY_BAR));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_WIFI, Constants.SERVICE_NAME_WIFI));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_MEETING_ROOM, Constants.SERVICE_NAME_MEETING_ROOM));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_EXTRA_AMENITIES, Constants.SERVICE_NAME_EXTRA_AMENITIES));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_CONCIERGE, Constants.SERVICE_NAME_CONCIERGE));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_MYLOCALPHONE, Constants.SERVICE_NAME_MYLOCALPHONE));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_SPA, Constants.SERVICE_NAME_SPA));
                break;
            case Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA :
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_BREAKFAST, Constants.SERVICE_NAME_BREAKFAST));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_HONESTY_BAR, Constants.SERVICE_NAME_HONESTY_BAR));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_WIFI, Constants.SERVICE_NAME_WIFI));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_MEETING_ROOM, Constants.SERVICE_NAME_MEETING_ROOM));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES, Constants.SERVICE_NAME_CONCIERGE_EXTRA_AMENITIES));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_SPA, Constants.SERVICE_NAME_SPA));
                break;
            case Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES :
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_BREAKFAST, Constants.SERVICE_NAME_BREAKFAST));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_HONESTY_BAR, Constants.SERVICE_NAME_HONESTY_BAR));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_WIFI, Constants.SERVICE_NAME_WIFI));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_MEETING_ROOM, Constants.SERVICE_NAME_MEETING_ROOM));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES, Constants.SERVICE_NAME_CONCIERGE_EXTRA_AMENITIES));
                serviceInfos.add(new ServiceInfo(Constants.SERVICE_ID_MYLOCALPHONE, Constants.SERVICE_NAME_MYLOCALPHONE));
                break;
            default :
                break;
        }
    }

    private static void createExtraInfos(int hotelId) {
        switch (hotelId) {
            case Constants.HOTEL_ID_ACACIAS_ETOILE :
                eInfos = new ExtraInfos("https://www.acacias-paris-hotel.com/fr/sanbot/meteo/",
                        "https://www.acacias-paris-hotel.com/fr/sanbot/se-promener-paris/",
                        "https://www.acacias-paris-hotel.com/fr/sanbot/photo-de-paris/",
                        "https://www.acacias-paris-hotel.com/fr/sanbot/restaurants-et-bars/");
                break;
            case Constants.HOTEL_ID_LA_VILLA_DES_TERNES :
                eInfos = new ExtraInfos("https://www.paris-hotel-ternes.com/en/sanbot-2/weather/",
                        "https://www.paris-hotel-ternes.com/en/sanbot-2/take-walk-paris/",
                        "https://www.paris-hotel-ternes.com/en/sanbot-2/photo-of-paris/",
                        "https://www.paris-hotel-ternes.com/en/sanbot-2/restaurants-and-bars/");
                break;
            case Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA :
                eInfos = new ExtraInfos("https://www.jardinsdelavilla.com/en/sanbot-2/weather/",
                        "https://www.jardinsdelavilla.com/en/sanbot-2/take-walk-paris/",
                        "https://www.jardinsdelavilla.com/en/sanbot-2/photo-of-paris/",
                        "https://www.jardinsdelavilla.com/en/sanbot-2/restaurants-and-bars/");
                break;
            case Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES :
                eInfos = new ExtraInfos("https://www.paris-hotel-magda.com/en/sanbot-2/weather/",
                        "https://www.paris-hotel-magda.com/en/sanbot-2/take-walk-paris/",
                        "https://www.paris-hotel-magda.com/en/sanbot-2/photo-of-paris/",
                        "https://www.paris-hotel-magda.com/en/sanbot-2/restaurants-and-bars/");
                break;
            default :
                break;
        }
    }

    /**
     * Model class of informations about a hotel service
     */
    public static class ServiceInfo {
        public final int id;
        public final String name;

        public ServiceInfo(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * Model class of extra information about a hotel.
     * You can use this model to add extra information to a hotel. In this case, use the right
     * constructor argument values(ExraInfos()) in the private hotel constructor.
     */
    public static class ExtraInfos {
        public final String weather;
        public final String transportation;
        public final String experience;
        public final String rbb;

        /**
         *
         * @param weather
         * @param transportation
         * @param experience
         * @param rbb
         */
        public ExtraInfos(String weather, String transportation, String experience, String rbb){
            this.weather = weather;
            this.transportation = transportation;
            this.experience = experience;
            this.rbb = rbb;
        }
    }

    /**
     * Model class of adress about a hotel.
     * You can use this model to add address informations to a hotel. In this case, use the right
     * constructor argument values(AddressInfos()) in the private hotel constructor.
     */
    private static class AddressInfos {
        public final int numberOfStarts;
        public final String street;
        public final int number;
        public final String city;
        public final String po;
        public final String phoneNumber;

        /**
         *
         * @param nbStarts
         * @param street
         * @param number
         * @param city
         * @param po
         * @param phoneNumber
         */
        public AddressInfos(int nbStarts, String street, int number, String city, String po, String phoneNumber){
            this.numberOfStarts = nbStarts;
            this.street = street;
            this.number = number;
            this.city = city;
            this.po = po;
            this.phoneNumber = phoneNumber;
        }
    }

}
