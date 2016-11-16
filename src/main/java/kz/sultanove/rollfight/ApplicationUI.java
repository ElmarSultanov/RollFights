package kz.sultanove.rollfight;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
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
public class ApplicationUI extends UI {
    final ApplicationInfoWindow win = new ApplicationInfoWindow();
    final VerticalLayout rootLayout = new VerticalLayout();
    HorizontalLayout applicationLayout = new HorizontalLayout();

    @Override
    protected void init(VaadinRequest request) {


        rootLayout.setSizeFull();
        applicationLayout.setSizeFull();

        final Panel headerPanel = new Panel("Myth-Application 0.1v");
        headerPanel.setIcon(new ThemeResource("swords.png"));
        headerPanel.setReadOnly(true);

        final MenuBar mainMenu = new MenuBar();
        setUpMenu(mainMenu);

        final Panel bottomPanel = new Panel("Created by Myth Ⓒ 2016");
        bottomPanel.setReadOnly(true);

        rootLayout.addComponents(headerPanel, mainMenu, applicationLayout, bottomPanel);
        rootLayout.setExpandRatio(mainMenu, 0);
        setContent(rootLayout);
    }

    private void setUpMenu(MenuBar mainMenu) {
        MenuBar.Command inProgress = (MenuBar.Command) menuItem -> Notification.show("В стадии разработки.");
        MenuBar.Command applicationInfoCommand = (MenuBar.Command) menuItem -> UI.getCurrent().addWindow(win);

        //info
        final MenuBar.MenuItem info = mainMenu.addItem("Информация", new ThemeResource("info.png"), null);
        info.setDescription("Инфо");
        final MenuBar.MenuItem infoHowToUse = info.addItem("Инструкции", new ThemeResource("info.png"), inProgress);
        infoHowToUse.setDescription("Как пользоваться приложением");
        final MenuBar.MenuItem infoRollfight = info.addItem("Ролл бои", new ThemeResource("info.png"), inProgress);
        infoRollfight.setDescription("Что такое система Ролл боев");
        final MenuBar.MenuItem infoSystem = info.addItem("Приложение", new ThemeResource("info.png"), applicationInfoCommand);
        infoSystem.setDescription("Информация по приложению");

        //rollfight
        final MenuBar.MenuItem rollfight = mainMenu.addItem("Ролл бои", new ThemeResource("rollfight.ico"), null);
        final MenuBar.MenuItem rollfightCommon = rollfight.addItem("Общее", new ThemeResource("star.ico"), inProgress);
        rollfightCommon.setDescription("Общая информация");
        final MenuBar.MenuItem rollfightMelee = rollfight.addItem("Ближний бой", new ThemeResource("swords.ico"), inProgress);
        rollfightMelee.setDescription("Ближний бой");
        final MenuBar.MenuItem rollfightRange = rollfight.addItem("Дальний бой", new ThemeResource("bow.png"), inProgress);
        rollfightRange.setDescription("Дальний бой");
        final MenuBar.MenuItem rollfightSpells = rollfight.addItem("Заклинания", new ThemeResource("magic.png"), inProgress);
        rollfightSpells.setDescription("Описание вошлебства");

        //Characters
        final MenuBar.MenuItem character = mainMenu.addItem("Персонажи", new ThemeResource("swords.png"), null);
        final MenuBar.MenuItem characterForm = character.addItem("Анекты", new ThemeResource("character.png"), inProgress);
        characterForm.setDescription("Анкета персонажей");
        final MenuBar.MenuItem npcStuff = character.addItem("НПС", new ThemeResource("character.png"), inProgress);
        npcStuff.setDescription("НПСы");
        final MenuBar.MenuItem characterGenerator = character.addItem("Генератор персонажей", new ThemeResource("generate.png"), inProgress);
        characterGenerator.setDescription("Сгенерировать персонажа");
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ApplicationUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
