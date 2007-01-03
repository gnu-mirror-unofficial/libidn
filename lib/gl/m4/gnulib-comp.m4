# DO NOT EDIT! GENERATED AUTOMATICALLY!
# Copyright (C) 2004-2007 Free Software Foundation, Inc.
#
# This file is free software, distributed under the terms of the GNU
# General Public License.  As a special exception to the GNU General
# Public License, this file may be distributed as part of a program
# that contains a configuration script generated by Autoconf, under
# the same distribution terms as the rest of that program.
#
# Generated by gnulib-tool.
#
# This file represents the compiled summary of the specification in
# gnulib-cache.m4. It lists the computed macro invocations that need
# to be invoked from configure.ac.
# In projects using CVS, this file can be treated like other built files.


# This macro should be invoked from ./configure.ac, in the section
# "Checks for programs", right after AC_PROG_CC, and certainly before
# any checks for libraries, header files, types and library functions.
AC_DEFUN([lgl_EARLY],
[
  m4_pattern_forbid([^gl_[A-Z]])dnl the gnulib macro namespace
  m4_pattern_allow([^gl_ES$])dnl a valid locale name
  m4_pattern_allow([^gl_LIBOBJS$])dnl a variable
  m4_pattern_allow([^gl_LTLIBOBJS$])dnl a variable
  AC_REQUIRE([AC_PROG_RANLIB])
  AC_REQUIRE([AC_GNU_SOURCE])
])

# This macro should be invoked from ./configure.ac, in the section
# "Check for header files, types and library functions".
AC_DEFUN([lgl_INIT],
[
  m4_pushdef([AC_LIBOBJ], m4_defn([lgl_LIBOBJ]))
  m4_pushdef([AC_REPLACE_FUNCS], m4_defn([lgl_REPLACE_FUNCS]))
  m4_pushdef([AC_LIBSOURCES], m4_defn([lgl_LIBSOURCES]))
  AM_CONDITIONAL([GL_COND_LIBTOOL], [true])
  gl_cond_libtool=true
  gl_source_base='lib/gl'
    AC_DEFINE([GNULIB_ABSOLUTE_HEADER], [1],
      [Define to 1 when using the gnulib module absolute-header.])
    AC_DEFINE([GNULIB_GETTEXT_H], [1],
      [Define to 1 when using the gnulib module gettext-h.])
    AC_DEFINE([GNULIB_HAVELIB], [1],
      [Define to 1 when using the gnulib module havelib.])
  AM_ICONV
    AC_DEFINE([GNULIB_ICONV], [1],
      [Define to 1 when using the gnulib module iconv.])
  gl_ICONVME
  if test $gl_cond_libtool = false; then
    gl_ltlibdeps="$gl_ltlibdeps $LTLIBICONV"
    gl_libdeps="$gl_libdeps $LIBICONV"
  fi
    AC_DEFINE([GNULIB_ICONVME], [1],
      [Define to 1 when using the gnulib module iconvme.])
  gl_STDINT_H
    AC_DEFINE([GNULIB_STDINT], [1],
      [Define to 1 when using the gnulib module stdint.])
  gl_FUNC_STRDUP
    AC_DEFINE([GNULIB_STRDUP], [1],
      [Define to 1 when using the gnulib module strdup.])
  gl_FUNC_STRVERSCMP
    AC_DEFINE([GNULIB_STRVERSCMP], [1],
      [Define to 1 when using the gnulib module strverscmp.])
  m4_popdef([AC_LIBSOURCES])
  m4_popdef([AC_REPLACE_FUNCS])
  m4_popdef([AC_LIBOBJ])
  AC_CONFIG_COMMANDS_PRE([
    lgl_libobjs=
    lgl_ltlibobjs=
    if test -n "$lgl_LIBOBJS"; then
      # Remove the extension.
      sed_drop_objext='s/\.o$//;s/\.obj$//'
      for i in `for i in $lgl_LIBOBJS; do echo "$i"; done | sed "$sed_drop_objext" | sort | uniq`; do
        lgl_libobjs="$lgl_libobjs $i.$ac_objext"
        lgl_ltlibobjs="$lgl_ltlibobjs $i.lo"
      done
    fi
    AC_SUBST([lgl_LIBOBJS], [$lgl_libobjs])
    AC_SUBST([lgl_LTLIBOBJS], [$lgl_ltlibobjs])
  ])
])

# Like AC_LIBOBJ, except that the module name goes
# into lgl_LIBOBJS instead of into LIBOBJS.
AC_DEFUN([lgl_LIBOBJ],
  [lgl_LIBOBJS="$lgl_LIBOBJS $1.$ac_objext"])

# Like AC_REPLACE_FUNCS, except that the module name goes
# into lgl_LIBOBJS instead of into LIBOBJS.
AC_DEFUN([lgl_REPLACE_FUNCS],
  [AC_CHECK_FUNCS([$1], , [lgl_LIBOBJ($ac_func)])])

# Like AC_LIBSOURCES, except that it does nothing.
# We rely on EXTRA_lib..._SOURCES instead.
AC_DEFUN([lgl_LIBSOURCES],
  [])

# This macro records the list of files which have been installed by
# gnulib-tool and may be removed by future gnulib-tool invocations.
AC_DEFUN([lgl_FILE_LIST], [
  build-aux/config.rpath
  lib/gettext.h
  lib/iconvme.c
  lib/iconvme.h
  lib/stdint_.h
  lib/strdup.c
  lib/strdup.h
  lib/strverscmp.c
  lib/strverscmp.h
  m4/absolute-header.m4
  m4/iconv.m4
  m4/iconvme.m4
  m4/lib-ld.m4
  m4/lib-link.m4
  m4/lib-prefix.m4
  m4/longlong.m4
  m4/stdint.m4
  m4/strdup.m4
  m4/strverscmp.m4
  m4/ulonglong.m4
])
