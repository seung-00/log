export default function Pre({...props}) {
  return (
      <div className='not-prose'>
        {props.children}
      </div>
  )
}
