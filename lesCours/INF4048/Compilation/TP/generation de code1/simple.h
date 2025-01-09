/* A Bison parser, made by GNU Bison 3.5.1.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018-2020 Free Software Foundation,
   Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* Undocumented macros, especially those whose name start with YY_,
   are private implementation details.  Do not rely on them.  */

#ifndef YY_YY_SIMPLE_H_INCLUDED
# define YY_YY_SIMPLE_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    DEBUTPROGRAMME = 258,
    FINPROGRAMME = 259,
    NOMBRE = 260,
    OPERATEUR = 261,
    VARIABLE = 262,
    IDFONCTION = 263,
    TANTQUE = 264,
    FAIRE = 265,
    FAIT = 266,
    ALORS = 267,
    BOUCLE = 268,
    COND = 269,
    SEPVAR = 270,
    SEPINSTR = 271,
    SYMBOLE = 272,
    TYPE = 273,
    AFFECTATION = 274,
    SI = 275,
    FSI = 276,
    SINON = 277,
    COMPARAISON = 278,
    PLUS = 279,
    MOINS = 280,
    FOIS = 281,
    DIVISER = 282,
    EGALE = 283,
    SUPERIEUR = 284,
    INFERIEUR = 285,
    DIFFERENT = 286,
    SUPEGALE = 287,
    INFEGALE = 288,
    LIRE = 289,
    ECRIRE = 290,
    COMPTER = 291,
    MODULO = 292
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_SIMPLE_H_INCLUDED  */
