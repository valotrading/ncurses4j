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

import com.sun.jna.NativeLibrary;
import com.sun.jna.ptr.IntByReference;

public interface NCurses {
    short COLOR_BLACK   = 0;
    short COLOR_RED     = 1;
    short COLOR_GREEN   = 2;
    short COLOR_YELLOW  = 3;
    short COLOR_BLUE    = 4;
    short COLOR_MAGENTA = 5;
    short COLOR_CYAN    = 6;
    short COLOR_WHITE   = 7;

    GlobalIntVariable COLOR_PAIRS = new GlobalIntVariable("COLOR_PAIRS");

    // Try to mimic the ncurses header file.
    int A_NORMAL     = (1 - 1);
    int A_STANDOUT   = NCURSES.BITS(1,  8);
    int A_UNDERLINE  = NCURSES.BITS(1,  9);
    int A_REVERSE    = NCURSES.BITS(1, 10);
    int A_BLINK      = NCURSES.BITS(1, 11);
    int A_DIM        = NCURSES.BITS(1, 12);
    int A_BOLD       = NCURSES.BITS(1, 13);
    int A_PROTECT    = NCURSES.BITS(1, 16);
    int A_INVIS      = NCURSES.BITS(1, 15);
    int A_ALTCHARSET = NCURSES.BITS(1, 14);
    int A_CHARTEXT   = NCURSES.BITS(1,  0) - 1;

    public static abstract class NCURSES {
        public static final int ATTR_SHIFT = 8;

        public static int BITS(int mask, int shift) {
            return mask << (shift + NCURSES.ATTR_SHIFT);
        }
    }
}
