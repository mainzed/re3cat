package link.labeling.retcat.rest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import link.labeling.retcat.log.Logging;
import link.labeling.retcat.queries.Retcat_ChronOntology;
import link.labeling.retcat.queries.Retcat_DBpedia;
import link.labeling.retcat.queries.Retcat_Getty;
import link.labeling.retcat.queries.Retcat_HTML;
import link.labeling.retcat.queries.Retcat_HeritageData;
import link.labeling.retcat.queries.Retcat_LabelingLink;
import link.labeling.retcat.queries.Retcat_LabelingSystem;
import link.labeling.retcat.queries.WaybackMachine;

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

    @GET
    @Path("/query/chronontology")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsChronOntology(@QueryParam("query") String searchword) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_ChronOntology.info(searchword.replace("uri:", "")));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_ChronOntology.query(searchword);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/info/chronontology")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getInfoChronOntology(@QueryParam("uri") String uri) {
        try {
            JSONObject jsonOut = Retcat_ChronOntology.info(uri);
            return Response.ok(jsonOut).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/query/labelingsystem")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsLabelingSystem(@QueryParam("query") String searchword, @HeaderParam(HttpHeaders.HOST) String host) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_LabelingSystem.info(searchword.replace("uri:", ""), host));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_LabelingSystem.query(searchword, host);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/query/labelingsystem/{vocabulary}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsLabelingSystemVocabulary(@QueryParam("query") String searchword, @PathParam("vocabulary") String vocabulary, @HeaderParam(HttpHeaders.HOST) String host) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_LabelingSystem.info(searchword.replace("uri:", ""), host));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_LabelingSystem.queryVocabulary(searchword, host, vocabulary);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/info/labelingsystem")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getInfoLabelingSystem(@QueryParam("uri") String uri, @HeaderParam(HttpHeaders.HOST) String host) {
        try {
            JSONObject jsonOut = Retcat_LabelingSystem.info(uri, host);
            return Response.ok(jsonOut).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/query/labelinglink")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsLabelingLink(@QueryParam("query") String searchword) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_LabelingLink.info(searchword.replace("uri:", "")));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_LabelingLink.query(searchword);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/info/labelinglink")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getInfoLabelingLink(@QueryParam("uri") String uri) {
        try {
            JSONObject jsonOut = Retcat_LabelingLink.info(uri);
            return Response.ok(jsonOut).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/query/dbpedia")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsDBpedia(@QueryParam("query") String searchword) {
        try {
            JSONArray outArray = new JSONArray();
            if (searchword.startsWith("uri:")) {
                outArray.add(Retcat_DBpedia.info(searchword.replace("uri:", "")));
                outArray.remove(new JSONObject());
            } else {
                outArray = Retcat_DBpedia.query(searchword);
            }
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/info/dbpedia")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getInfoDBpedia(@QueryParam("uri") String uri) {
        try {
            JSONObject jsonOut = Retcat_DBpedia.info(uri);
            return Response.ok(jsonOut).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/query/html")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getQueryResultsHTML(@QueryParam("query") String url) {
        try {
            JSONArray outArray = new JSONArray();
            outArray = Retcat_HTML.query(url);
            return Response.ok(outArray).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/info/html")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getInfoExtern(@QueryParam("url") String url, @QueryParam("type") String type) {
        try {
            JSONObject jsonOut = Retcat_HTML.info(url);
            return Response.ok(jsonOut).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

    @GET
    @Path("/waybacklink")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getWaybackURL(@QueryParam("url") String url) {
        try {
            return Response.ok(WaybackMachine.getURI(url)).header("Content-Type", "application/json;charset=UTF-8").build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Logging.getMessageJSON(e, "link.labeling.retcat.utils.RetcatREST"))
                    .header("Content-Type", "application/json;charset=UTF-8").build();
        }
    }

}
