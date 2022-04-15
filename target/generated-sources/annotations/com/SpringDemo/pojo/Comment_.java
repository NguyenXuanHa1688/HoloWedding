package com.SpringDemo.pojo;

import com.SpringDemo.pojo.User;
import com.SpringDemo.pojo.Wedding;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-15T21:21:00")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Wedding> idWedding;
    public static volatile SingularAttribute<Comment, Integer> comid;
    public static volatile SingularAttribute<Comment, String> dateCreate;
    public static volatile SingularAttribute<Comment, String> content;
    public static volatile SingularAttribute<Comment, User> username;

}