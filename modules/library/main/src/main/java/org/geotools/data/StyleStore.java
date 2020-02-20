/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2020, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.data;

import java.io.IOException;

import org.geotools.styling.Style;

/**
 * This represents physical sources of feature data that also provide storage for Style infomation.  
 * It was originally designed to augment the geoPackage class, but by creating this interface other
 * DataStores that can have embedded / related style information can implement this interface.  A good
 * example of this would be a shapefile with a .SLD file with the same basename.  ShapefuleDatastore once
 * it implements this interface will handle that case.
 * 
 * @see DataAcess
 * @see org.geotools.data.shapefile.ShapefileDatastore
 * @see org.geotools.styling.Style
 * @author Mark D Henning
 * @version $Id$
 *
 */

public interface StyleStore {
	/**
	 * Used to determine whether the DataStore contains (or is accompanied by) default styling information.
	 * @param typeName
	 * @return true if styling information exists, otherwise false.
	 * @throws IOException
	 */
	boolean hasStyle(String typeName) throws IOException;
	/**
	 * Used to parse the embedded style information and return the Style object.
	 * @param typeName
	 * @return parsed Style object.
	 * @throws IOException
	 */
	Style getStyle(String typeName) throws IOException;
	
	/**
	 * Used to remove an existing style object from a StyleStore
	 * @param typeName
	 * @throws IOException
	 */
	void removeStyle(String typeName) throws IOException;
	
	/**
	 * used to store (replace existing or save new)
	 * @param typeName
	 * @param style
	 * @throws IOException
	 */
	void storeStyle(String typeName, Style style) throws IOException;
	
}
