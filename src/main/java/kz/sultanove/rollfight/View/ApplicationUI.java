package kz.sultanove.rollfight.View;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import kz.sultanove.rollfight.Entity.Character;
import kz.sultanove.rollfight.Entity.Postgresql;
import kz.sultanove.rollfight.Entity.Spell;
import kz.sultanove.rollfight.Entity.Weapon;
import kz.sultanove.rollfight.Helpers.ApplicationInfoWindow;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class ApplicationUI extends UI {
    Postgresql postgresql = new Postgresql();
    final ApplicationInfoWindow win = new ApplicationInfoWindow();
    final VerticalLayout rootLayout = new VerticalLayout();
    Collection<Weapon> weaponCollection = new ArrayList<>();
    Collection<Spell> spellCollection = new ArrayList<>();
    Collection<Character> characterCollection = new ArrayList<>();
    BeanItemContainer<Spell> spellContainer;
    BeanItemContainer<Weapon> weaponContainer;
    BeanItemContainer<Character> characterContainer;
    HorizontalLayout applicationLayout = new HorizontalLayout();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Table weaponTable;
    Table spellTable;
    Table characterTable;
    BrowserFrame  page = new BrowserFrame("Генератор персонажа", new ExternalResource(
            "http://rpstats.co.nf/"));


    @Override
    protected void init(VaadinRequest request) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Myth", "postgres",
                    "111");
            getDataFromDB(connection);
            initTable();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }



        final Panel headerPanel = new Panel("Myth-Application 0.1v");
        headerPanel.setIcon(new ThemeResource("swords.png"));
        headerPanel.setReadOnly(true);

        final MenuBar mainMenu = new MenuBar();
        setUpMenu(mainMenu);

        final Panel bottomPanel = new Panel("Created by Myth Ⓒ 2016");
        bottomPanel.setReadOnly(true);


        rootLayout.addComponents(headerPanel, mainMenu, applicationLayout, bottomPanel);

        applicationLayout.setHeight("100%");
        applicationLayout.setWidth("100%");

        rootLayout.setWidth("100%");
        rootLayout.setSpacing(true);
        setContent(rootLayout);
    }

    private void initTable() {
        spellContainer = new BeanItemContainer<>(Spell.class, spellCollection);
        weaponContainer = new BeanItemContainer<>(Weapon.class, weaponCollection);
        characterContainer = new BeanItemContainer<>(Character.class, characterCollection);
        weaponTable = new Table("Weapon Table", weaponContainer);
        spellTable = new Table("Spell Table", spellContainer);
        characterTable = new Table("Character Table", characterContainer);
    }


    private void getDataFromDB(Connection connection) throws SQLException {
        if (connection != null){
            preparedStatement = connection.prepareStatement(postgresql.getSelectWeapon());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Weapon weapon = new Weapon();
                weapon.setName(rs.getString("name"));
                weapon.setDescription(rs.getString("description"));
                weaponCollection.add(weapon);
            }
            preparedStatement = connection.prepareStatement(postgresql.getSelectSpell());
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Spell spell = new Spell();
                spell.setId(rs.getInt("id"));
                spell.setName(rs.getString("name"));
                spell.setSpellDescription(rs.getString("description"));
                spell.setSpellLevel(rs.getInt("level"));
                spell.setSpellSchool(rs.getString("school"));
                spellCollection.add(spell);
            }
            preparedStatement = connection.prepareStatement(postgresql.getSelectCharacter());
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Character character = new Character();
                character.setId(rs.getInt("id"));
                character.setCharacterName(rs.getString("name"));
                character.setStrenght(rs.getInt("strength"));
                character.setAgility(rs.getInt("agility"));
                character.setConstitution(rs.getInt("constitution"));
                character.setIntellegence(rs.getInt("intelligence"));
                character.setWillpower(rs.getInt("willpower"));
                character.setPerseption(rs.getInt("perseption"));
                character.setAlignment(rs.getString("alignment"));
                character.setExpPoint(rs.getInt("experience"));
                character.setCharacterLevel(rs.getInt("level"));
                character.setMovement(rs.getString("movement"));
                character.setAbility(rs.getString("ability"));
                character.setSpell("spell");
                character.setWeaponName_byId(rs.getString("\"Weapon\".name"));
                characterCollection.add(character);
            }
            preparedStatement.close();
            connection.close();
        }
    }

    private void setUpMenu(MenuBar mainMenu) {
        MenuBar.Command inProgress = (MenuBar.Command) menuItem -> Notification.show("В стадии разработки.");
        MenuBar.Command applicationInfoCommand = (MenuBar.Command) menuItem -> {
            if(UI.getCurrent().getWindows().size() == 0) UI.getCurrent().addWindow(win);
        };
        MenuBar.Command rollfightMeleeCommand = (MenuBar.Command) menuItem ->{
            applicationLayout.removeAllComponents();
            weaponTable.setSizeFull();
            applicationLayout.addComponent(weaponTable);
        };
        MenuBar.Command rollfightSpellCommand = (MenuBar.Command) menuItem ->{
            applicationLayout.removeAllComponents();
            spellTable.setSizeFull();
            applicationLayout.addComponent(spellTable);
        };
        MenuBar.Command characterGeneratorCommand = (MenuBar.Command) menuItem ->{
            applicationLayout.removeAllComponents();
            page.setHeight("750px");
            page.setWidth("100%");
            applicationLayout.addComponent(page);

        };
        MenuBar.Command characterShowCommand = (MenuBar.Command) menuItem ->{
            applicationLayout.removeAllComponents();
            characterTable.setSizeFull();
            characterTable.setColumnCollapsingAllowed(true);
            applicationLayout.addComponent(characterTable);
        };


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
        final MenuBar.MenuItem rollfightMelee = rollfight.addItem("Ближний бой", new ThemeResource("swords.png"), rollfightMeleeCommand);
        rollfightMelee.setDescription("Ближний бой");
        final MenuBar.MenuItem rollfightRange = rollfight.addItem("Дальний бой", new ThemeResource("bow.png"), inProgress);
        rollfightRange.setDescription("Дальний бой");
        final MenuBar.MenuItem rollfightSpells = rollfight.addItem("Заклинания", new ThemeResource("magic.png"), rollfightSpellCommand);
        rollfightSpells.setDescription("Описание вошлебства");

        //Characters
        final MenuBar.MenuItem character = mainMenu.addItem("Персонажи", new ThemeResource("swords.png"), null);
        final MenuBar.MenuItem characterForm = character.addItem("Анекты", new ThemeResource("character.png"), characterShowCommand);
        characterForm.setDescription("Анкета персонажей");
        final MenuBar.MenuItem npcStuff = character.addItem("НПС", new ThemeResource("character.png"), inProgress);
        npcStuff.setDescription("НПСы");
        final MenuBar.MenuItem characterGenerator = character.addItem("Генератор персонажей", new ThemeResource("generate.png"), characterGeneratorCommand);
        characterGenerator.setDescription("Сгенерировать персонажа");
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ApplicationUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
