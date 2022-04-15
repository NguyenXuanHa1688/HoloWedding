package com.SpringDemo.pojo;

import com.SpringDemo.pojo.User;
import com.SpringDemo.pojo.Wedding;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-15T21:21:00")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Integer> totalPrice;
    public static volatile SingularAttribute<Booking, Wedding> idWedding;
    public static volatile SingularAttribute<Booking, Integer> idBook;
    public static volatile SingularAttribute<Booking, User> username;

}