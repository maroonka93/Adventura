/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.Objects;

/**
 * Implements things that are in rooms (and inventory)
 * @author MP
 */
public class Thing {
    
    private boolean pickable;
    private final String name;
    //private String description;
    private final boolean lookableInto;
    private Thing content = null;
    private String condition = null;

    /**
      Constructor of things, sets whether things are pickable and lookable into, name of the thing
     * @param pickable
     * @param name
     * @param lookableInto
     */
    public Thing(boolean pickable, String name, boolean lookableInto) {
        this.pickable = pickable;
        this.name = name;
        this.lookableInto = lookableInto;
    }

    /**
     * getter for pickable
     * @return boolean pickable
     */
    public boolean isPickable() {
        return pickable;
    }

    /**
     * getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for lookable into
     * @return boolean lookableInto
     */
    public boolean isLookableInto() {
        return lookableInto;
    }

    /**
     * getter for content
     * @return Thing content
     */
    public Thing getContent() {
        return content;
    }
    
    /**
     * getter for condition
     * @return String condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * setter for pickable
     * @param pickable
     */
    public void setPickable(boolean pickable) {
        this.pickable = pickable;
    }
    
    /**
     * setter for content
     * @param content
     */
    public void setContent(Thing content) {
        this.content = content;
    }

    /**
     * setter for condition
     * @param condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    /**
     * removes content of a thing
     */
    public void removeContent() {
        this.content = null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Thing other = (Thing) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
   
    
    
}
