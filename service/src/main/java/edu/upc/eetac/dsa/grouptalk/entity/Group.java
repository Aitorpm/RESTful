package edu.upc.eetac.dsa.grouptalk.entity;

import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by Aitor on 24/10/15.
 */
public class Group {
    @InjectLinks({})
    private List<Link> links;
    private String id;
    private String name;
}
