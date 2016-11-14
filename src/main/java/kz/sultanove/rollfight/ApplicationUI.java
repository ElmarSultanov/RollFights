package kz.sultanove.rollfight;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class ApplicationUI extends UI implements View {
    Navigator navigator;
    protected static final String MAINVIEW = "main";

    public ApplicationUI(){
        setSizeFull();

            getPage().setTitle("Navigation Example");
            navigator = new Navigator(this, this);
            navigator.addView("", new ScreenView());
            navigator.addView(MAINVIEW, new ApplicationUI());

            final VerticalLayout layout = new VerticalLayout();
            final Label header = new Label("Добро пожаловать!");
            header.setWidthUndefined();
            final Label body = new Label("Приветствую, ролевик. Ты находишься на стартовой странице приложения Myth-Application 0.1v!" +
                    " Что бы продолжить знакомство с этой чудестной программой нажми кнопку \"Войти\"." +
                    " Что бы поддержать проект поставь плюсик на сам знаешь какому форуме, сам знаешь кому или поставь минус Ухо, спасибо!");
            Button button = new Button("Войти");
            button.addClickListener((Button.ClickListener) clickEvent -> {
                navigator.navigateTo(MAINVIEW);
                //  Notification.show("Во имя Милорда!","  Враги Альянса устроили саботаж! Функция временно не доступна, агенты Си-9 уже работают над этим.", Notification.Type.ERROR_MESSAGE);
            });

            layout.addComponents(header, body,button);
            layout.setComponentAlignment(header, Alignment.MIDDLE_CENTER);
            layout.setComponentAlignment(body, Alignment.MIDDLE_CENTER);
            layout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
            layout.setMargin(true);
            layout.setSpacing(true);
            layout.setSizeFull();
            setContent(layout);

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ApplicationUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
