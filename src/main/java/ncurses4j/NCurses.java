/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ncurses4j;

public abstract class NCurses {
    public static final short COLOR_BLACK   = 0;
    public static final short COLOR_RED     = 1;
    public static final short COLOR_GREEN   = 2;
    public static final short COLOR_YELLOW  = 3;
    public static final short COLOR_BLUE    = 4;
    public static final short COLOR_MAGENTA = 5;
    public static final short COLOR_CYAN    = 6;
    public static final short COLOR_WHITE   = 7;

    public static final GlobalIntVariable COLOR_PAIRS = new GlobalIntVariable("COLOR_PAIRS");

    // Try to mimic the ncurses header file.
    public static final int A_NORMAL     = (1 - 1);
    public static final int A_STANDOUT   = NCURSES.BITS(1,  8);
    public static final int A_UNDERLINE  = NCURSES.BITS(1,  9);
    public static final int A_REVERSE    = NCURSES.BITS(1, 10);
    public static final int A_BLINK      = NCURSES.BITS(1, 11);
    public static final int A_DIM        = NCURSES.BITS(1, 12);
    public static final int A_BOLD       = NCURSES.BITS(1, 13);
    public static final int A_PROTECT    = NCURSES.BITS(1, 16);
    public static final int A_INVIS      = NCURSES.BITS(1, 15);
    public static final int A_ALTCHARSET = NCURSES.BITS(1, 14);
    public static final int A_CHARTEXT   = NCURSES.BITS(1,  0) - 1;

    public static abstract class NCURSES {
        public static final int ATTR_SHIFT = 8;

        public static int BITS(int mask, int shift) {
            return mask << (shift + NCURSES.ATTR_SHIFT);
        }
    }
}
