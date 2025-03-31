import Markdown from "react-markdown";
import remarkGfm from "remark-gfm";
import remarkMermaid from "remark-mermaidjs";
import Img from "./Img";
import CodeBlock from "./CodeBlock";
import Pre from "./Pre";
import React from "react";
import {IMAGE_BASE_URL} from "../../../core/constant";
import useTOC from "../../../core/hooks/useTOC";
import useIsDesktop from "../../../core/hooks/useIsDesktop";

const getPath = (uri: string) => {
  const pattern = /images\/(.+\.png)/;
  const match = pattern.exec(uri);

  return match ? `${match[1]}` : null;
}

const transformImageUri = (uri: string) => {
  if (!uri.startsWith("http") && uri.includes('.png')) {
    return `${IMAGE_BASE_URL}${getPath(uri)}`
  }

  return uri
}

type Props = {
  content: string;
  onHeadingsExtracted: (headings: { id: string, text: string, level: number }[]) => void | null;
  onIntersectHeadings: (id: string) => void | null;
};

export default function MarkdownWrapper({content, onHeadingsExtracted, onIntersectHeadings}: Props) {
  const isDesktop = useIsDesktop()
  const contentContainerRef = useTOC(
      content, onHeadingsExtracted, onIntersectHeadings, isDesktop
  )

  return (
      <article className="
        prose
        max-w-none

        prose-h1:my-6
        prose-h1:font-bold
        prose-h1:text-gray-800

        prose-h2:my-4
        prose-h2:text-gray-800

        prose-h3:my-2
        prose-h3:text-gray-800

        prost-p:text-black

        prose-a:text-blue-700
        prose-a:no-underline
        hover:prose-a:underline
        " ref={contentContainerRef}
      >
        <Markdown
            // @ts-ignore
            // https://github.com/remarkjs/react-markdown/issues/680
            remarkPlugins={[remarkGfm, remarkMermaid]}
            urlTransform={transformImageUri}
            components={{
              img: Img,
              code: CodeBlock,
              pre: Pre
            }}>
          {content}
        </Markdown>
      </article>
  )
}
