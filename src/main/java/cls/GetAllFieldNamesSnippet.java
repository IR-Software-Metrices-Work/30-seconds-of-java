/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cls;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 30 Seconds of Java code library
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllFieldNamesSnippet {
  /**
   * Print all declared field names of the class or the interface the class extends.
   *
   * @param clazz Tested class
   * @return list of names of all fields
   */
  public static List<String> getAllFieldNames(final Class<?> clazz) {
    var fields = new ArrayList<String>();
    var currentClazz = clazz;
    while (currentClazz != null) {
      fields.addAll(
          Arrays.stream(currentClazz.getDeclaredFields())
              .filter(field -> !field.isSynthetic())
              .map(Field::getName)
              .collect(Collectors.toList()));
      currentClazz = currentClazz.getSuperclass();
    }
    return fields;
  }
}
