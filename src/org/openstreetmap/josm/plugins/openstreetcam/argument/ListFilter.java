/*
 *  Copyright 2016 Telenav, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.openstreetmap.josm.plugins.openstreetcam.argument;

import java.util.Date;
import com.telenav.josm.common.util.EntityUtil;


/**
 * Defines the filters that the user can use to reduce the displayed results.
 *
 * @author Beata
 * @version $Revision$
 */
public class ListFilter {

    /** the default filter */
    public static final ListFilter DEFAULT = new ListFilter(null, false);

    private final Date date;
    private final boolean onlyUserFlag;


    /**
     * Builds a new filter with the given arguments.
     *
     * @param date a {@code Date} the photos that were uploaded after the specified date will be displayed
     * @param onlyUserFlag if true only the current user's photos will be displayed
     */
    public ListFilter(final Date date, final boolean onlyUserFlag) {
        this.date = date;
        this.onlyUserFlag = onlyUserFlag;
    }

    public Date getDate() {
        return date;
    }

    public boolean isOnlyUserFlag() {
        return onlyUserFlag;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + EntityUtil.hashCode(date);
        result = prime * result + EntityUtil.hashCode(onlyUserFlag);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else if (obj instanceof ListFilter) {
            final ListFilter other = (ListFilter) obj;
            result = EntityUtil.bothNullOrEqual(date, other.getDate());
            result = result && (onlyUserFlag == other.isOnlyUserFlag());
        }
        return result;
    }

    public boolean isDefaultFilter() {
        return DEFAULT.equals(this);
    }
}