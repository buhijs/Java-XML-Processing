package com.realdolmen.jxp010;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;

public class MainJaxb {
    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Address address = new Address("A. Vaucampslaan", "Huizingen", "1657", "42");
        Person p = new Person("Nicolas", "Quartier", address, "nicolasquartier@msn.com","quartier.nicolas@gmail.com");

        marshaller.marshal(p, new FileWriter("person.xml"));
    }
}
