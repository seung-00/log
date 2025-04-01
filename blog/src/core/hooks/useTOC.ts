import {useEffect, useRef} from "react";

interface Heading {
  id: string;
  text: string;
  level: number;
};

export default function useTOC(
    content: string,
    onHeadingsExtracted?: (headings: Heading[]) => void,
    onIntersectHeadings?: (id: string) => void,
    enabledSpy?: boolean,
) {
  const contentContainerRef = useRef<HTMLDivElement>(null);

  // toc rendering
  useEffect(() => {
    if (!contentContainerRef.current || !onHeadingsExtracted) {
      return;
    }

    const headings = Array.from(contentContainerRef.current.querySelectorAll("h1, h2, h3")) as HTMLHeadingElement[];

    const extracted = headings.map((element) => {
      const text = element.textContent || "";
      const level = parseInt(element.tagName[1], 10);

      element.id = text;
      return {id: text, text, level};
    });

    onHeadingsExtracted(extracted);
  }, [contentContainerRef, content, onHeadingsExtracted]);

  // toc scroll spy
  useEffect(() => {
    if (!contentContainerRef.current || !onIntersectHeadings) {
      return;
    }
    if (!enabledSpy) {
      return;
    }

    const headings = Array.from(contentContainerRef.current.querySelectorAll("h1, h2, h3"));

    const observer = new IntersectionObserver((entries) => {
          entries.forEach((entry) => {
            if (!entry.isIntersecting) {
              return;
            }

            const id = entry.target.id;
            if (id) {
              onIntersectHeadings(id);
            }
          });
        },
        {
          rootMargin: "0px 0px -50% 0px", // 요소가 스크롤 상단 50% 지점에 가시될 때 트리거
          threshold: 1.0,
        }
    );

    headings.forEach((heading) => observer.observe(heading));
    return () => observer.disconnect();
  }, [contentContainerRef, content, onIntersectHeadings, enabledSpy]);

  return contentContainerRef;
}
