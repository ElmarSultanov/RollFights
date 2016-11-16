package kz.sultanove.rollfight;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class ApplicationInfoWindow extends Window {
    public ApplicationInfoWindow(){
        super("Myth-Rollfight 0.1");
        center();
        VerticalLayout content = new VerticalLayout();
        content.addComponent(new Label("Разработано в 2016, ролевиками с RP сервера Valkyrie-Wow"));
        content.setMargin(true);
        setWidth("40%");
        setHeight("40%");
        setContent(content);
    }
}
