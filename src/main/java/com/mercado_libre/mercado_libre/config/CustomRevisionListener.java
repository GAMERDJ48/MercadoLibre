package com.mercado_libre.mercado_libre.config;

import com.mercado_libre.mercado_libre.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity){
        final Revision revision = (Revision) revisionEntity;
    }
}
