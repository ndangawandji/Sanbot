/**
 * Model class representing the hotel service list on an hotel.
 * Developed by Ndanga Wandji.
 */

package fr.mylocalphone.sanbot.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.commons.DrawablePicture;

public class HotelServices {

    /**
     * An array of sample (hotel service) items.
     */
    public static final List<HotelService> ITEMS = new ArrayList<>();

    /**
     * A map of sample (hotel service) items, by ID.
     */
    public static final Map<String, HotelService> ITEM_MAP = new HashMap<>();

    private int COUNT;

    static {
        // Add hotel services.
        for (Hotel.ServiceInfo sInfo: Hotel.getServiceInfos()) {
            addItem(createHotelService(Hotel.getId(), sInfo,
                    SanbotApp.getApplication().getResources()));
        }
    }

    private static void addItem(HotelService item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    /**
     * This method is used to create an hotel service
     * @param hotelId
     * @param serviceInfo
     * @param res
     * @return
     */
    private static HotelService createHotelService(int hotelId, Hotel.ServiceInfo serviceInfo, Resources res) {
        String title = new String();
        String content = new String();
        String speech = new String();
        Drawable picture = new DrawablePicture();
        if(hotelId == Constants.HOTEL_ID_ACACIAS_ETOILE) {
            switch (serviceInfo.id) {
                case Constants.SERVICE_ID_BREAKFAST :
                    title = res.getString(R.string.breakfast_service_title);
                    content = res.getString(R.string.breakfast_service_content_text);
                    speech = res.getString(R.string.breakfast_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_breakfast_acacias_etoile);
                    break;
                case Constants.SERVICE_ID_HONESTY_BAR :
                    title = res.getString(R.string.honesty_bar_service_title);
                    content = res.getString(R.string.honesty_bar_service_content_text,"");
                    speech = res.getString(R.string.honesty_bar_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_honesty_bar_acacias_etoile);
                    break;
                case Constants.SERVICE_ID_WIFI :
                    title = res.getString(R.string.wifi_service_title);
                    content = res.getString(R.string.wifi_service_content_text,res.getString(R.string.wifi_acacais_etoile), "");
                    speech = res.getString(R.string.wifi_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_wifi_acacias_etoile);
                    break;
                case Constants.SERVICE_ID_MEETING_ROOM :
                    title = res.getString(R.string.meeting_room_service_title);
                    content = res.getString(R.string.meeting_room_service_content_text, res.getString(R.string.meeting_room_service_content_text_acacias_magda));
                    speech = res.getString(R.string.meeting_room_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_meeting_room_acacias_etoile_magda);
                    break;
                case Constants.SERVICE_ID_EXTRA_AMENITIES :
                    title = res.getString(R.string.extra_amenities_service_title);
                    content = res.getString(R.string.extra_amenities_service_content_text, res.getString(R.string.extra_amenities_services_content_text_complement_acacias_ternes));
                    speech = res.getString(R.string.extra_amenities_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_extra_amenities_acacias_etoile);
                    break;
                case Constants.SERVICE_ID_CONCIERGE :
                    title = res.getString(R.string.concierge_service_title);
                    content = res.getString(R.string.concierge_service_content_text, "");
                    speech = res.getString(R.string.concierge_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_concierge_acacias_etoile_magda);
                    break;
                default:
                    break;
            }
        }
        else if(hotelId == Constants.HOTEL_ID_LA_VILLA_DES_TERNES) {
            switch (serviceInfo.id) {
                case Constants.SERVICE_ID_BREAKFAST :
                    title = res.getString(R.string.breakfast_service_title);
                    content = res.getString(R.string.breakfast_service_content_text_ternes);
                    speech = res.getString(R.string.breakfast_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_breakfast_la_villa_des_ternes);
                    break;
                case Constants.SERVICE_ID_HONESTY_BAR :
                    title = res.getString(R.string.honesty_bar_service_title);
                    content = res.getString(R.string.honesty_bar_service_content_text, res.getString(R.string.honesty_bar_service_content_text_complement_ternes_jardins));
                    speech = res.getString(R.string.honesty_bar_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_honesty_bar_la_villa_des_ternes);
                    break;
                case Constants.SERVICE_ID_WIFI :
                    title = res.getString(R.string.wifi_service_title);
                    content = res.getString(R.string.wifi_service_content_text, res.getString(R.string.wifi_la_villa_des_ternes), res.getString(R.string.wifi_service_content_text_complement_magda_ternes));
                    speech = res.getString(R.string.wifi_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_wifi_la_villa_des_ternes);
                    break;
                case Constants.SERVICE_ID_MEETING_ROOM :
                    title = res.getString(R.string.meeting_rooms_service_title);
                    content = res.getString(R.string.meeting_room_service_content_text_ternes_jardins);
                    speech = res.getString(R.string.meeting_room_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_meeting_room_hotel_service);
                    break;
                case Constants.SERVICE_ID_EXTRA_AMENITIES :
                    title = res.getString(R.string.extra_amenities_service_title);
                    content = res.getString(R.string.extra_amenities_service_content_text, res.getString(R.string.extra_amenities_services_content_text_complement_acacias_ternes));
                    speech = res.getString(R.string.extra_amenities_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_concierge_extra_amenities_hotel_service);
                    break;
                case Constants.SERVICE_ID_CONCIERGE :
                    title = res.getString(R.string.concierge_service_title);
                    content = res.getString(R.string.concierge_service_content_text, "");
                    speech = res.getString(R.string.concierge_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_concierge_acacias_etoile);
                    break;
                case Constants.SERVICE_ID_MYLOCALPHONE :
                    title = res.getString(R.string.mylocalphone_service_title);
                    content = res.getString(R.string.mylocalphone_service_content_text, res.getString(R.string.mylocalphone_service_content_text_terne));
                    speech = res.getString(R.string.mylocalphone_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_mylocalphone);
                    break;
                case Constants.SERVICE_ID_SPA :
                    title = res.getString(R.string.spa_service_title);
                    content = res.getString(R.string.spa_service_content_text, res.getString(R.string.spa_service_content_text_terne));
                    speech = res.getString(R.string.spa_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_spa_hotel_service);
                    break;
                default:
                    break;
            }
        }
        else if(hotelId == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA) {
            switch (serviceInfo.id) {
                case Constants.SERVICE_ID_BREAKFAST :
                    title = res.getString(R.string.breakfast_service_title);
                    content = res.getString(R.string.breakfast_service_content_text_jardins);
                    speech = res.getString(R.string.breakfast_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_breakfast_les_jardins_de_la_villa);
                    break;

                case Constants.SERVICE_ID_HONESTY_BAR :
                    title = res.getString(R.string.honesty_bar_service_title);
                    content = res.getString(R.string.honesty_bar_service_content_text, res.getString(R.string.honesty_bar_service_content_text_complement_ternes_jardins));
                    speech = res.getString(R.string.honesty_bar_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_honesty_bar_les_jardins_de_la_ville);
                    break;

                case Constants.SERVICE_ID_WIFI :
                    title = res.getString(R.string.wifi_service_title);
                    content = res.getString(R.string.wifi_service_content_text, res.getString(R.string.wifi_les_jardins_de_la_villa), "");
                    speech = res.getString(R.string.wifi_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_wifi_les_jardins_de_la_villa);
                    break;

                case Constants.SERVICE_ID_MEETING_ROOM :
                    title = res.getString(R.string.meeting_rooms_service_title);
                    content = res.getString(R.string.meeting_room_service_content_text_ternes_jardins);
                    speech = res.getString(R.string.meeting_room_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_meeting_room_hotel_service);
                    break;
                case Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES :
                    title = res.getString(R.string.concierge_extra_amenities_service_title);
                    content = res.getString(R.string.concierge_service_content_text, "") + res.getString(R.string.extra_amenities_service_content_text, res.getString(R.string.extra_amenities_services_content_text_jardins_magda));
                    speech = res.getString(R.string.concierge_service_speech_content) + res.getString(R.string.extra_amenities_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_concierge_extra_amenities_hotel_service);
                    break;
                case Constants.SERVICE_ID_SPA :
                    title = res.getString(R.string.spa_service_title);
                    content = res.getString(R.string.spa_service_content_text, res.getString(R.string.spa_service_content_text_jardin));
                    speech = res.getString(R.string.spa_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_spa_hotel_service);
                    break;
                default:
                    break;
            }
        }
        else if(hotelId == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES) {
            switch (serviceInfo.id) {
                case Constants.SERVICE_ID_BREAKFAST :
                    title = res.getString(R.string.breakfast_service_title);
                    content = res.getString(R.string.breakfast_service_content_text_magda_champs_elysees);
                    speech = res.getString(R.string.breakfast_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_breakfast_magda_champs_elysees);
                    break;
                case Constants.SERVICE_ID_HONESTY_BAR :
                    title = res.getString(R.string.honesty_bar_service_title);
                    content = res.getString(R.string.honesty_bar_service_content_text, res.getString(R.string.honesty_bar_service_content_text_complement));
                    speech = res.getString(R.string.honesty_bar_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_honesty_bar_magda_champs_elysees);
                    break;
                case Constants.SERVICE_ID_WIFI :
                    title = res.getString(R.string.wifi_service_title);
                    content = res.getString(R.string.wifi_service_content_text, res.getString(R.string.wifi_magda_champs_elysees), res.getString(R.string.wifi_service_content_text_complement_magda_ternes));
                    speech = res.getString(R.string.wifi_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_wifi_magda_champs_elysees);
                    break;
                case Constants.SERVICE_ID_MEETING_ROOM :
                    title = res.getString(R.string.meeting_room_service_title);
                    content = res.getString(R.string.meeting_room_service_content_text, res.getString(R.string.meeting_room_service_content_text_acacias_magda));
                    speech = res.getString(R.string.meeting_room_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_meeting_room_acacias_etoile_magda);
                    break;
                case Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES :
                    title = res.getString(R.string.concierge_extra_amenities_service_title);
                    content = res.getString(R.string.concierge_service_content_text, "") + res.getString(R.string.extra_amenities_service_content_text, res.getString(R.string.extra_amenities_services_content_text_jardins_magda));
                    speech = res.getString(R.string.concierge_service_speech_content) + res.getString(R.string.extra_amenities_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_concierge_acacias_etoile_magda);
                    break;
                case Constants.SERVICE_ID_MYLOCALPHONE :
                    title = res.getString(R.string.mylocalphone_service_title);
                    content = res.getString(R.string.mylocalphone_service_content_text, res.getString(R.string.mylocalphone_service_content_text_magda));
                    speech = res.getString(R.string.mylocalphone_service_speech_content);
                    picture = res.getDrawable(R.drawable.image_mylocalphone);
                    break;
                default:
                    break;
            }
        }
        else {
        }
        return new HotelService(serviceInfo.id, title, picture, content, speech);
    }
    public static HotelService returnHotelService(int id) {
        HotelService hotelService = null;
        for (HotelService item: ITEMS) {
            if(item.id == id) {
                hotelService = item;
            }
        }
        return hotelService;
    }

    /**
     * Model class representing an hotel service
     */
    public static class HotelService {
        public int id;
        public String name;
        public Drawable picture;
        public String content;
        public String speech;

        public HotelService(int id, String name, Drawable picture, String content, String speech) {
            this.id = id;
            this.name = name;
            this.picture = picture;
            this.content = content;
            this.speech = speech;
        }
    }
}
