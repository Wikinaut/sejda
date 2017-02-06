/*
 * Created on 03 feb 2017
 * Copyright 2015 by Andrea Vacondio (andrea.vacondio@gmail.com).
 * This file is part of Sejda.
 *
 * Sejda is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Sejda is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Sejda.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sejda.model.parameter.image;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.sejda.model.image.ImageColorType;
import org.sejda.model.image.ImageType;

/**
 * Parameters to converta PDF to png images
 * 
 * @author Andrea Vacondio
 *
 */
public class PdfToPngParameters extends AbstractPdfToMultipleImageParameters {

    public PdfToPngParameters(ImageColorType type) {
        super(type);
    }

    @Override
    public ImageType getOutputImageType() {
        return ImageType.PNG;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PdfToPngParameters)) {
            return false;
        }
        return new EqualsBuilder().appendSuper(super.equals(other)).isEquals();
    }
}