module proyecto.hibernateproyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens proyecto.hibernateproyecto to javafx.fxml;
    exports proyecto.hibernateproyecto;
}
