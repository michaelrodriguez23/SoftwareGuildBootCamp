/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.daos;

import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface DAO<T> {

    public T Create(T DTO);

    public List<T> ReadAll();

    public T ReadById(int id);

    public boolean Update(T DTO);

}