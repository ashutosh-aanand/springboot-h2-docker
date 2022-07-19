package com.docker.springH2docker;

import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository <Book, Integer>{
    
}
