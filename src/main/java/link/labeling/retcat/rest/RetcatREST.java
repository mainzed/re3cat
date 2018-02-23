package link.labeling.retcat.rest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import link.labeling.retcat.log.Logging;
import link.labeling.retcat.queries.Retcat_Getty;
import link.labeling.retcat.queries.Retcat_HeritageData;

@Path("/rtc")
public class RetcatREST {

    @GET
    @Path("/query/getty/aat")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsGettyAAT(@QueryParam("query") String searchword) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_Getty.info(searchword.replace("uri:", "")));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_Getty.queryAAT(searchword);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/query/getty/tgn")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsGettyTGN(@QueryParam("query") String searchword) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_Getty.info(searchword.replace("uri:", "")));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_Getty.queryTGN(searchword);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/query/getty/ulan")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsGettyULAN(@QueryParam("query") String searchword) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_Getty.info(searchword.replace("uri:", "")));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_Getty.queryULAN(searchword);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/info/getty")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getInfoGetty(@QueryParam("uri") String uri) {
        try {
            JSONObject jsonOut = Retcat_Getty.info(uri);
            return Response.ok(jsonOut).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }
    
    @GET
	@Path("/query/heritagedata/historicengland")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public Response getQueryResultsHeritagedataHE(@QueryParam("query") String searchword) {
		try {
			JSONArray outArray = new JSONArray();
			if (searchword.startsWith("uri:")) {
				outArray.add(Retcat_HeritageData.info(searchword.replace("uri:", "")));
				outArray.remove(new JSONObject());
			} else {
				outArray = Retcat_HeritageData.queryHE(searchword);
			}
			return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
					.header("Content-Type", "application/json;charset=UTF-8").build();
		}
	}

	@GET
	@Path("/query/heritagedata/rcahms")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public Response getQueryResultsHeritagedataRCAHMS(@QueryParam("query") String searchword) {
		try {
			JSONArray outArray = new JSONArray();
			if (searchword.startsWith("uri:")) {
				outArray.add(Retcat_HeritageData.info(searchword.replace("uri:", "")));
				outArray.remove(new JSONObject());
			} else {
				outArray = Retcat_HeritageData.queryRCAHMS(searchword);
			}
			return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
					.header("Content-Type", "application/json;charset=UTF-8").build();
		}
	}

	@GET
	@Path("/query/heritagedata/rcahmw")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public Response getQueryResultsHeritagedataRCAHMW(@QueryParam("query") String searchword) {
		try {
			JSONArray outArray = new JSONArray();
			if (searchword.startsWith("uri:")) {
				outArray.add(Retcat_HeritageData.info(searchword.replace("uri:", "")));
				outArray.remove(new JSONObject());
			} else {
				outArray = Retcat_HeritageData.queryRCAHMW(searchword);
			}
			return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
					.header("Content-Type", "application/json;charset=UTF-8").build();
		}
	}

	@GET
	@Path("/info/heritagedata")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public Response getInfoHeritageData(@QueryParam("uri") String uri) {
		try {
			JSONObject jsonOut = Retcat_HeritageData.info(uri);
			return Response.ok(jsonOut).header("Content-Type", "application/json;charset=UTF-8").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
					.header("Content-Type", "application/json;charset=UTF-8").build();
		}
	}

}
