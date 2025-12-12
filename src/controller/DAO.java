/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author FCFC
 */
public interface DAO <C, I>{
    void save(C p);
    void delete(I id);
    void update(C p, I id);
    ArrayList<C> getAll();
    C findById(I id);
}
