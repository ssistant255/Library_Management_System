package com.library_Magament_system.dao;
import java.util.List;

import com.library_management_system.pojo.Libraries;
public interface LibrariesDao 
{
	boolean addLibraries(Libraries l);
	List<Libraries>showLibraries();
}
