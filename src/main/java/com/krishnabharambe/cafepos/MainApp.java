package com.krishnabharambe.cafepos;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println("=== Start Of Application ===");

        System.out.println("=== Saving Data ===");
//        Alien alien = new Alien();
//        alien.setId(5);
//        alien.setAge(58);
//        alien.setName("Krishna238");
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(alien);

        System.out.println("=== End Of Saving Data ");
        System.out.println("=== Getting Data ===");

        Alien alien1 = (Alien) session.get(Alien.class, new Integer("1"));
        System.out.println(alien1);

        session.getTransaction().commit();
        session.close();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("CafePOS - Young Mugs Cafe");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
