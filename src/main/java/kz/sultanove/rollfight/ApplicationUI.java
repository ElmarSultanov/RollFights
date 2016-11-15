package kz.sultanove.rollfight;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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


    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.setSizeFull();

        final Panel headerPanel = new Panel("Myth-Application 0.1v");
        headerPanel.setIcon(new ThemeResource("swords.png"));
        headerPanel.setReadOnly(true);

        final MenuBar mainMenu = new MenuBar();
        setUpMenu(mainMenu);

        final Panel bottomPanel = new Panel("Created by Myth Ⓒ 2016");
        bottomPanel.setReadOnly(true);

        rootLayout.addComponents(headerPanel, mainMenu, bottomPanel);
        setContent(rootLayout);
    }

    private void setUpMenu(MenuBar mainMenu) {
        //info
        final MenuBar.MenuItem info = mainMenu.addItem("Information", new ThemeResource("info.png"), null);
        info.setDescription("Info");
        final MenuBar.MenuItem infoHowToUse = info.addItem("How to Use", new ThemeResource("info.png"), null);
        infoHowToUse.setDescription("How to use application");
        final MenuBar.MenuItem infoRollfight = info.addItem("What is RollFight", new ThemeResource("info.png"), null);
        infoRollfight.setDescription("RollFight");
        final MenuBar.MenuItem infoSystem = info.addItem("Application info", new ThemeResource("info.png"), null);
        infoSystem.setDescription("Application Version");

        //rollfight
        final MenuBar.MenuItem rollfight = mainMenu.addItem("Rollfight", new ThemeResource("rollfight.ico"), null);
        final MenuBar.MenuItem rollfightCommon = rollfight.addItem("Common", new ThemeResource("rollfight.ico"), null);
        rollfightCommon.setDescription("Common");
        final MenuBar.MenuItem rollfightSpells = rollfight.addItem("Spells", new ThemeResource("rollfight.ico"), null);
        rollfightSpells.setDescription("Spells");

        //Characters
        final MenuBar.MenuItem character = mainMenu.addItem("Character", new ThemeResource("swords.png"), null);
        final MenuBar.MenuItem characterStuff = character.addItem("Characters", new ThemeResource("character.png"), null);
        characterStuff.setDescription("Characters");
        final MenuBar.MenuItem characterGenerator = character.addItem("Generate character", new ThemeResource("generate.png"), null);
        characterGenerator.setDescription("Generate character");
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ApplicationUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
