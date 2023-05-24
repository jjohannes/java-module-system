module my.product.service {
    requires transitive my.product.data;
    requires org.apache.commons.lang3;
    exports my.product.service;
}