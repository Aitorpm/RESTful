package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.ThemeDAO;
import edu.upc.eetac.dsa.grouptalk.dao.ThemeDAOImpl;
import edu.upc.eetac.dsa.grouptalk.dao.UserDidntSubscribedException;
import edu.upc.eetac.dsa.grouptalk.entity.Theme;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by Aitor on 28/10/15.
 */
@Path("themes")
public class ThemeSource {
    @Context
    private SecurityContext securityContext;
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createSting(@FormParam("namegroup") String namegroup, @FormParam("subject") String subject, @FormParam("content") String content, @Context UriInfo uriInfo) throws URISyntaxException {
        if(namegroup==null || subject==null || content == null)
            throw new BadRequestException("all parameters are mandatory");
        String userid = securityContext.getUserPrincipal().getName();

        ThemeDAO themeDAO = new ThemeDAOImpl();
        Theme theme = null;
        try {
            theme = themeDAO.createTheme(userid, namegroup, subject, content);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        } catch (UserDidntSubscribedException e) {
            e.printStackTrace();
        }
        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + theme.getId());
        return Response.created(uri).type(GrouptalkMediaType.GROUPTALK_THEME).entity(theme).build();
    }
}
