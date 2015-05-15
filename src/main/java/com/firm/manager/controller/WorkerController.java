package com.firm.manager.controller;

import com.firm.manager.FacesUtil;
import com.firm.manager.dao.control.WorkerManager;
import com.firm.manager.dao.entity.Worker;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

@ManagedBean
@ViewScoped
public class WorkerController {
    private static final Logger logger = Logger.getLogger(WorkerController.class);

    @Inject
    private WorkerManager workerManager;
    @Inject
    private FacesUtil facesUtil;
    @NotNull(message = "Musisz wybraæ pracownika")
    private Worker selectedWorker;

    private List<Worker> workers;

    @PostConstruct
    public void init() {
        workers = workerManager.findNotDeleted();
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public Worker getSelectedWorker() {
        return selectedWorker;
    }

    public void setSelectedWorker(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }
}

