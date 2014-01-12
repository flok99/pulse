/*
 * Copyright 2013-2014 the original author or authors.
 *
 * This file is part of Pulse Chess.
 *
 * Pulse Chess is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Pulse Chess is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Pulse Chess.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxchess.pulse;

import com.fluxchess.jcpi.models.GenericPosition;
import com.fluxchess.jcpi.models.IntFile;
import com.fluxchess.jcpi.models.IntRank;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static com.fluxchess.test.AssertUtil.assertUtilityClassWellDefined;
import static org.junit.Assert.*;

public class SquareTest {

  @Test
  public void testUtilityClass() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertUtilityClassWellDefined(Square.class);
  }

  @Test
  public void testValues() {
    for (GenericPosition genericPosition : GenericPosition.values()) {
      int square = Square.valueOf(genericPosition);
      assertTrue(Square.isLegal(square));
      assertTrue(Square.isValid(square));
      assertEquals(genericPosition, Square.toGenericPosition(square));

      int file = Square.getFile(square);
      assertTrue(IntFile.isValid(file));
      assertEquals(genericPosition.file.ordinal(), file);
      assertEquals(genericPosition.file, IntFile.toGenericFile(file));

      int rank = Square.getRank(square);
      assertTrue(IntRank.isValid(rank));
      assertEquals(genericPosition.rank.ordinal(), rank);
      assertEquals(genericPosition.rank, IntRank.toGenericRank(rank));
    }

    assertFalse(Square.isLegal(Square.NOSQUARE));
    assertFalse(Square.isValid(Square.NOSQUARE));
  }

}