import {Prism as SyntaxHighlighter} from 'react-syntax-highlighter';
import {oneLight} from 'react-syntax-highlighter/dist/cjs/styles/prism';

export default function CodeBlock({...props}) {
  const {children, className, node, ...rest} = props
  const match = /language-(\w+)/.exec(className || '')

  return match ? (
      <SyntaxHighlighter
          {...rest}
          children={String(children).replace(/\n$/, '')}
          language={match[1]}
          style={oneLight}
          showLineNumbers={true}
          className="not-prose rounded-md"
      />
  ) : (
      <code {...rest} className={className}>
        {children}
      </code>
  )
}
