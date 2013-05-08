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

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public abstract class NCurses {
    private static final NativeLibrary LIBRARY = NativeLibrary.getInstance("ncurses");

    private static final IntByReference COLOR_PAIRS = new IntByReference();

    static {
        Native.register(LIBRARY);

        COLOR_PAIRS.setPointer(LIBRARY.getGlobalVariableAddress("COLOR_PAIRS"));
    }

    public static final short COLOR_BLACK   = 0;
    public static final short COLOR_RED     = 1;
    public static final short COLOR_GREEN   = 2;
    public static final short COLOR_YELLOW  = 3;
    public static final short COLOR_BLUE    = 4;
    public static final short COLOR_MAGENTA = 5;
    public static final short COLOR_CYAN    = 6;
    public static final short COLOR_WHITE   = 7;

    // Try to mimic the ncurses header file.
    public static final int A_NORMAL     = (1 - 1);
    public static final int A_STANDOUT   = NCURSES_BITS(1,  8);
    public static final int A_UNDERLINE  = NCURSES_BITS(1,  9);
    public static final int A_REVERSE    = NCURSES_BITS(1, 10);
    public static final int A_BLINK      = NCURSES_BITS(1, 11);
    public static final int A_DIM        = NCURSES_BITS(1, 12);
    public static final int A_BOLD       = NCURSES_BITS(1, 13);
    public static final int A_PROTECT    = NCURSES_BITS(1, 16);
    public static final int A_INVIS      = NCURSES_BITS(1, 15);
    public static final int A_ALTCHARSET = NCURSES_BITS(1, 14);
    public static final int A_CHARTEXT   = NCURSES_BITS(1,  0) - 1;

    private static final int NCURSES_ATTR_SHIFT = 8;

    private static int NCURSES_BITS(int mask, int shift) {
        return mask << (shift + NCURSES_ATTR_SHIFT);
    }

    public static int COLOR_PAIRS() {
        return COLOR_PAIRS.getValue();
    }

    public static native int     COLOR_PAIR(int pair);
    public static native int     attroff(int attrs);
    public static native int     attron(int attrs);
    public static native int     attrset(int attrs);
    public static native int     clear();
    public static native int     endwin();
    public static native int     erase();
    public static native int     getch();
    public static native int     getmaxx(Pointer win);
    public static native int     getmaxy(Pointer win);
    public static native boolean has_colors();
    public static native Pointer initscr();
    public static native int     init_pair(short pair, short f, short b);
    public static native int     mvprintw(int y, int x, String str);
    public static native int     printw(String str);
    public static native int     refresh();
    public static native int     start_color();
}
