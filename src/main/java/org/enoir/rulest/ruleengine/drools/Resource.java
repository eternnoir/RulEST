package org.enoir.rulest.ruleengine.drools;

import org.kie.api.io.ResourceType;

/**
 * Created by frank on 2015/4/2.
 */
public class Resource {
    private String path;
    private PathType pathType;
    private ResourceType type;
    private String username = null;
    private String password = null;

    public Resource(String path,PathType pathType,ResourceType type){
        this.path = path;
        this.type = type;
        this.pathType = pathType;
    }

    public Resource(String path,ResourceType type,String username,String pwd){
        this.path = path;
        this.type = type;
        this.username = username;
        this.password = pwd;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PathType getPathType() {
        return pathType;
    }

    public void setPathType(PathType pathType) {
        this.pathType = pathType;
    }
}
