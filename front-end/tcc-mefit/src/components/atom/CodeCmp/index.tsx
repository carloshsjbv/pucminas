import React from 'react';
import {
  StyContainer,
  StyCode,
  StyWordFormatter,
  StyLineContainer,
} from './styles';

interface ICodeCmp {
  lines: string[];
}

enum WORD_KEYS {
  IF = 'if',
  OPEN_PARENTHESES = '(',
  CLOSE_PARENTHESES = ')',
  FUNCTION = 'function',
  INCLUDES = 'includes',
  STRING = 'string',
  NUMBER = 'number',
  PUSH = 'push',
  RETURN = 'return',
  COLON = ':',
  SEMICOLON = ';',
  OPEN_BRACES = '{',
  CLOSE_BRACES = '}',
  EQUALS = '=',
  PLUS = '+',
  SUBTRACT = '-',
  MULTIPLY = '*',
  IMPORT = 'import',
  FROM = 'from',
  QUOTATIONS = '"',
  SPAN = 'span',
  DIV = 'div',
  CONST = 'CONST',
  USE_EFFECT = 'useEffect',
  USE_MEMO = 'useMemo',
  REACT_FC = 'REACT.FC',
  GRATHER = '</',
  LESS = '>',
  ARROW = '=>',
  EXPORT = 'export',
  DEFAULT = 'default',
}

enum WORD_KEYS_COLOR {
  IF = '#ff79c6',
  OPEN_PARENTHESES = '#fff',
  CLOSE_PARENTHESES = '#fff',
  FUNCTION = '#ff79c6',
  INCLUDES = '#50fa7b',
  STRING = '#8be9fd',
  NUMBER = '#8be9fd',
  PUSH = '#50fa7b',
  RETURN = '#ff79c6',
  COLON = '#ff79c6',
  SEMICOLON = '#ff79c6',
  OPEN_BRACES = '#fff',
  CLOSE_BRACES = '#fff',
  EQUALS = '#ff79c6',
  PLUS = '#ff79c6',
  SUBTRACT = '#ff79c6',
  MULTIPLY = '#ff79c6',
  IMPORT = '#ff79c6',
  FROM = '#ff79c6',
  QUOTATIONS = '#e6db74',
  SPAN = '#ff79c6',
  DIV = '#ff79c6',
  CONST = '#ff79c6',
  USE_EFFECT = '#50fa7b',
  USE_MEMO = '#50fa7b',
  REACT_FC = '#8be9fd',
  GRATHER = '#ff79c6',
  LESS = '#ff79c6',
  NORMAL = '#fff',
  ARROW = '#ff79c6',
  EXPORT = '#ff79c6',
  DEFAULT = '#ff79c6',
}

const CodeCmp: React.FC<ICodeCmp> = ({ lines = [] }) => {
  function handleWordStyle(line: string): string[] {
    let word: string = line;
    const wordKeys: any = WORD_KEYS;
    const wordKeysColor: any = WORD_KEYS_COLOR;

    Object.keys(wordKeys).forEach(key => {
      if (word.includes(wordKeys[key])) {
        //let replaceThis = wordKeys[key];
        //const regex: RegExp = new RegExp(`\b\${replaceThis}`, 'g');
        //word = word.replace(regex, wordKeys[key]);
        word = word.replace(wordKeys[key], `__${wordKeys[key]}__`);
      }
    });

    const words: string[] = word.split('__');
    const styledLine = words.map((line: string) => {
      let styledWord: string = `${line} _color_ ${WORD_KEYS_COLOR.NORMAL} `;
      Object.keys(wordKeys).forEach(key => {
        if (line === wordKeys[key]) {
          styledWord = `${line} _color_ ${wordKeysColor[key]} `;
        }
      });
      return styledWord;
    });

    return styledLine;
  }

  return (
    <StyContainer>
      <StyCode>
        {lines.map((line: string) => {
          return (
            <StyLineContainer>
              {handleWordStyle(line).map((word: string) => {
                const wordSplit: string[] = word.split('_color_');
                return (
                  <StyWordFormatter color={wordSplit[1]}>
                    {wordSplit[0]}
                  </StyWordFormatter>
                );
              })}
            </StyLineContainer>
          );
        })}
      </StyCode>
    </StyContainer>
  );
};

export default CodeCmp;
