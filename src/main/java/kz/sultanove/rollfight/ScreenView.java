package kz.sultanove.rollfight;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by e.sultanov on 14.11.2016.
 */
@DesignRoot
public class ScreenView extends VerticalLayout implements View {
    Navigator navigator;
    protected static final String MAINVIEW = "main";

    class ButtonListener implements Button.ClickListener {
        String menuitem;
        public ButtonListener(String menuitem) {
            this.menuitem = menuitem;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            // Navigate to a specific state
            navigator.navigateTo(MAINVIEW + "/" + menuitem);
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Welcome", Notification.Type.TRAY_NOTIFICATION);
        logout.addClickListener((Button.ClickListener) clickEvent -> navigator.navigateTo(""));
    }
    VerticalLayout menuContent;
    Panel equalPanel;
    Button logout;
}
