module proyecto.hibernateproyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    //requires hibernate.validator;

    opens proyecto.hibernateproyecto to javafx.fxml;
    opens entidades;
    opens controladores;
    opens repositorio;
    exports proyecto.hibernateproyecto;
}
