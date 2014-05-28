package com.demien.hibgeneric.service;

import java.util.List;

import com.demien.hibgeneric.dao.IGenericDAO;

public interface IGenericService<T> extends IGenericDAO<T> {
  List<T> getAll();
  void deleteAll();
}
