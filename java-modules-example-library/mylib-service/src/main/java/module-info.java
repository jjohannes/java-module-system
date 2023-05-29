module org.example.mylib.service {
    requires transitive org.example.mylib.data;
    requires org.apache.commons.lang3;
    exports org.example.mylib.service;
}