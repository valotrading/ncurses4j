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

package ncurses4j.examples;

import com.sun.jna.Pointer;
import ncurses4j.NCurses;
import ncurses4j.NCursesLibrary;

public class HelloWorld {

    public static void main(String[] args) {
        NCursesLibrary ncurses = NCursesLibrary.INSTANCE;
        Pointer stdscr;

        stdscr = ncurses.initscr();

        if (ncurses.has_colors()) {
            ncurses.start_color();

            if (NCurses.COLOR_PAIRS.get() > 1) {
                ncurses.init_pair((short) 1, NCurses.COLOR_BLACK, NCurses.COLOR_WHITE);
                ncurses.attron(ncurses.COLOR_PAIR(1));
            }
        }

        ncurses.attron(NCurses.A_BOLD);

        int maxx = ncurses.getmaxx(stdscr);
        int maxy = ncurses.getmaxy(stdscr);

        String message = "Hello World";

        int x = maxx / 2 - message.length() / 2;
        int y = maxy / 2;

        ncurses.erase();
        ncurses.mvprintw(y, x, message);
        ncurses.refresh();
        ncurses.getch();
        ncurses.endwin();
    }

}
