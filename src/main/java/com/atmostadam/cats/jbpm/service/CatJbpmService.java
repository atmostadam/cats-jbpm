package com.atmostadam.cats.jbpm.service;

import com.atmostadam.cats.api.exception.CatException;
import org.jbpm.services.api.DeploymentService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.server.api.model.ReleaseId;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerStatus;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.services.api.KieServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class CatJbpmService {
    Logger logger = LoggerFactory.getLogger(CatJbpmService.class);

    public static final String SRC_DIR = "./src";

    public static final String JBPM_EXT = ".bpmn2";

    @Autowired
    private BuildProperties buildProperties;

    @Autowired
    private KieServer kieServer;

    @Autowired
    private DeploymentService deploymentService;

    @PostConstruct
    public void setup() {
        String containerId = "kjar:10.10.01";
        //ReleaseId releaseId = new ReleaseId(buildProperties.getGroup(), buildProperties.getArtifact(),
        //        buildProperties.getVersion());
        //KieContainerResource container =
        //        new KieContainerResource(containerId, releaseId, KieContainerStatus.STARTED);
        //ServiceResponse<KieContainerResource> response  = kieServer.createContainer(containerId, container);

    }

    /*
    @Autowired
    private CatKieService kieService;

    private KieContainer kieContainer;

    @PostConstruct
    protected void setup() throws CatException {
        KieServices ks = KieServices.Factory.get();
        Map<String, Resource> kieFiles = kieService.loadKieFiles(SRC_DIR, JBPM_EXT);
        logger.info("Kie Maven dependency found [{}] bpmn2 files", kieFiles.size());
        if (kieFiles.size() == 0) {
            throw new IllegalStateException(
                    "Illegal State in Classloader. Kie Maven dependency found zero bpmn2 files.");
        }
        KieFileSystem kfs = kieService.writeResources(ks, kieFiles);
        ks.newKieBuilder(kfs).buildAll();
        kieContainer = ks.newKieContainer(ks.newReleaseId(
                buildProperties.getGroup(),
                buildProperties.getArtifact(),
                buildProperties.getVersion()));
    }
    */
}
