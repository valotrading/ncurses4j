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

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface NCursesLibrary extends Library {
    NCursesLibrary INSTANCE = (NCursesLibrary) Native.loadLibrary("ncurses", NCursesLibrary.class);

    int     COLOR_PAIR(int pair);
    int     attroff(int attrs);
    int     attron(int attrs);
    int     clear();
    int     endwin();
    int     erase();
    int     getch();
    boolean has_colors();
    Pointer initscr();
    int     init_pair(short pair, short f, short b);
    int     mvprintw(int x, int y, String fmt, Object... args);
    int     printw(String fmt, Object... args);
    int     refresh();
    int     start_color();
}
