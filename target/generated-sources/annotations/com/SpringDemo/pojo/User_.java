package com.SpringDemo.pojo;

import com.SpringDemo.pojo.Booking;
import com.SpringDemo.pojo.Comment;
import com.SpringDemo.pojo.Wedding;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-15T21:21:00")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> role;
    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile SingularAttribute<User, Wedding> idWedding;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile CollectionAttribute<User, Booking> bookingCollection;
    public static volatile SingularAttribute<User, String> username;

}